#include <iostream>

using namespace std;

int main()

{
   int N;
   cin>>N;
   int t[N];
   int t2[N];

   int licznik =0;
   int i;


cout<<N;

   for (i=0; i<N; ++i)

   std::cin>>t[i];

   for(i=0; i<N; i++)

     if(t[i] != t[i+1]){
         licznik++;
         cout<<t[i];
     }



cout<<licznik<<"\n";


}
