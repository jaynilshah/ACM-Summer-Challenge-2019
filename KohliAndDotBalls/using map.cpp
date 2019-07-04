#include<bits/stdc++.h>
using namespace std;
int main()
{
    long long int n,i;
    cin>>n;
 
    map<long long int,vector<long long int> > mp;
 
    long long int one=0,zero=0;
    mp[0].push_back(0);
    for(i=1;i<=n;i++)
    {
        long long int y;
        cin>>y;
        if(y==0)
            zero++;
        else
            one++;
 
        mp[one-(2*zero)].push_back(i);
 
    }
    long long int ans=0;
    map<long long int,vector<long long int> >::iterator it=mp.begin();
    for(;it!=mp.end();it++)
    {
        if(mp[it->first].size()>1)
        {
            long long int x=mp[it->first].size();
            ans=max(ans,it->second[x-1]-it->second[0]);
        }
    }
 
    cout<<ans;
 
}
