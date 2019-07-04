#include<bits/stdc++.h>
using namespace std;
int main()
{

 
    long long int n,m,i;
    cin>>n>>m;
 
    long long int a[3]={0};
 
    for(i=1;i<=m;i++)
        a[i%3]++;
 
    long long int ans=0;
 
    for(i=1;i<=n;i++)
    {
        ans+=a[(3-(i%3))%3];
    }
 
    cout<<ans;
 
}