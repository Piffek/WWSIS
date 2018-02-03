#include <iostream>
#include <algorithm>

using namespace std;

int main()
{

    int n;
    cin >> n;
    int p[n];

    for (int i = 0; i < n; i++){
        cin >> p[i];
    }

    int c[n];

    c[0] = p[0];

    for (int i = 1; i<= 6 && i< n; i++){
        c[i] = p[i] + *max_element(c, c+i);

    }

        for(int i = 7; i < n; i++){
            c[i] =p[i] + *max_element(c+(i-6), c+i);
        }

    cout << c[n-1] << endl;
    return 0;
}
