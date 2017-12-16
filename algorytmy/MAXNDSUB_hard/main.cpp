#include <iostream>
#include <algorithm>
#include <stack>
#include <vector>

using namespace std;

int main()
{
    int n;
    cin >> n;

    int a[n];

    for(int i=0; i<n; i++){
        cin >> a[i];
    }

    vector<int> d;
    d.push_back(0);



    for(int i=0; i<n; i++){
        int p = 0;
        int q = d.size() - 1;
        while (p <= q){
            int m = (p + q) / 2;

            if(d[m] <= a[i]) {
                p = m + 1;
            } else {
                q = m - 1;
            }
        }

        if( p == d.size()){
            d.push_back(a[i]);
        } else {
            d[p] = a[i];
        }

    }
    cout << (d.size() - 1) << endl;
    return 0;
}
