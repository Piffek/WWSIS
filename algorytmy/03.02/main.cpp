#include <iostream>
#include <stdexcept>

using namespace std;

class node {
    int value;
    node *left, *right;

public:
    node(int v) : value(v) {
        left = right = nullptr;
    }

    int val() const {
        return value;
    }

    node* search_min() {
        if(left){
            return left->search_min();
        }else {
            return this;
        }
    }

    node* search_max() {
        if(right){
            return right->search_max();
        }else {
            return this;
        }
    }

    node* search(int v) {
        if(v < value){
            if(left) return left->search(v);
            else return nullptr;
        }
        if(value < v){
            if(right) return right->search(v);
            else return nullptr;
        }
        else return this;
    }

    node* prev(int v) {
        if(v < value){
            if(left) return left->prev(v);
            else return nullptr;
        }
        else if(value < v){
            if(right){
                node *nd = right->prev(v);
                if(nd && nd->value < v) return nd;
                else return this;
            }
            else return this;
        }
        else {
            if(left) return left->search_max();
            else return nullptr;
        }
    }

    node* insert(int v) {
        if(v < value){
            if(left) left = left->insert(v);
            else left = new node(v);
        }
        if(value < v){
            if(right) right = right->insert(v);
            else right = new node(v);
        }
        return this;
    }

public:
    friend ostream& operator << (ostream &out, const node *nd) {
        if(nd->left) out << nd->left << ", ";
        out << nd->value;

        if(nd->right) out << ", " << nd->right;
        return out;
    }
};

class bst {
    node *root;

public:
    bst() : root(nullptr) {
    }

public:

    int prev(int v) {
        if (!root) {
            throw invalid_argument("drzewo puste");
        }

        node *nd = root->prev(v);
        if(!nd) {
            throw invalid_argument("brak poprzednika");
        }
        return nd->val();
    }

    void insert(int v) {
        if (root) {
            root->insert(v);
        } else {
            root = new node(v);
        }
    }

    bool search(int v) {
        if (root) {
            return root->search(v) != nullptr;
        } else {
            return false;
        }
    }


public:
    // przejæcie po drzewie
    friend ostream &operator<<(ostream &out, const bst &t) {
        if (t.root) {
            out << "[" << t.root << "]";
        } else {
            out << "[]";
        }
        return out;
    }


};



int main()
{
    bst t;
    t.insert(7);
    t.insert(4);
    t.insert(9);
    t.insert(8);
    t.insert(5);
    t.insert(2);
    cerr << t << endl;
    cerr << "prev 7 = " << t.prev(7) << endl;
    cerr << "prev 6 = " << t.prev(6) << endl;
    cerr << "prev 5 = " << t.prev(5) << endl;
    cerr << "prev 8 = " << t.prev(8) << endl;
    cerr << "prev 9 = " << t.prev(9) << endl;
    return 0;

}
