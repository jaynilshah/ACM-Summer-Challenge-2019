#include<bits/stdc++.h>
using namespace std;
int main()
{
    long long int n,k,i;
    cin>>n>>k;
    string s;
    cin>>s;
    vector<long long int> v;
    v.push_back(-1);
    for(i=0;i<n;i++)
    {
        if(s[i]=='1')
            v.push_back(i);
    }
    v.push_back(n);
 
    long long int ans=0;
    long long int idx=1;
    long long int si=v.size();
    while(true)
    {
        if(idx+k-1<si-1)
        {
            long long int l=v[idx]-v[idx-1];
            long long int r=v[idx+k]-v[idx+k-1];
            ans+=l*r;
            idx++;
        }
        else
            break;
    }
 
    cout<<ans;
}
