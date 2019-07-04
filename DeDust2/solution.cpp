#include<bits/stdc++.h>
using namespace std;
int main()
{
    long long int n,i;
    cin>>n;

    map<long long int,long long int> mp,mpp;
    for(i=0;i<n;i++)
    {
        long long int x,y;
        cin>>x>>y;
        mp[x+y]++;
        mpp[x-y]++;
    }


    long long int ans=0;
    map<long long int,long long int>::iterator it;

    for(it=mp.begin();it!=mp.end();it++)
        ans+=((it->second)*((it->second)-1))/2;

    for(it=mpp.begin();it!=mpp.end();it++)
        ans+=((it->second)*((it->second)-1))/2;
    
    cout<<ans;

}
