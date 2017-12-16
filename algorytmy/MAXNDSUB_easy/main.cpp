#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    int n;
    cin >> n;

    int a[n];

    for(int i=0; i<n; i++){
        cin >> a[i];
    }

    int c[n];

    for(int i=0; i<n; i++){
        int k = 0;
        for (int j = 0; j<i; j++){
            if(a[j] <= a[i] && c[j] > k){
                k = c[j];
            }
        }
        c[i] = k+1;

    }
    cout << *max_element(c, c + n) << endl;
    return 0;
}
