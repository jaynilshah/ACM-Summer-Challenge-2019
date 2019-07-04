#include<bits/stdc++.h>
using namespace std;
int main()
{
    long long int t;
    cin>>t;
    while(t--){
    long long int n,m,k,i;
    cin>>n>>m>>k;
    long long int ans=-1;
    
    for(i=2;i<=sqrt(n);i++)
    {
        if(n%i==0)
        {
            if(__gcd(i,m)>k)
                ans=max(ans,i);
                
            if(__gcd(n/i,m)>k)
                ans=max(ans,n/i);
        }
    }
    
    cout<<ans<<"\n";}
}
