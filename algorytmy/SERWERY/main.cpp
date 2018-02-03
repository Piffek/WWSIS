#include <iostream>

using namespace std;

int main()
{
    int n;
    int k;

    cin >> n >> k;

    long long s[n + 1];

    s[0] = 1;

    for(int i = 1; i <= n; i++){
        s[i] = s[i - 1] * i;
    }

    cout << (s[n] / s[n-k]) << endl;
}
