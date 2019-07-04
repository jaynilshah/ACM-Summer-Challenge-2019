#include<bits/stdc++.h>
using namespace std;
int main()
{
 
 
    long long int n,i;
    cin>>n;
 
    //to store the index where the particular xor value occured
    map<long long int,vector<long long int> > mp;
    mp[0].push_back(0);
 
    long long int xorv=0;
 
    for(i=1;i<=n;i++)
    {
        long long int y;
        cin>>y;
        xorv=xorv^y;
        mp[xorv].push_back(i);
    }
 
    long long int ans=0;
 
    map<long long int,vector<long long int> >::iterator it;
 
    for(it=mp.begin();it!=mp.end();it++)
    {
        //if a xor value occurs more than once then it creates a subarray with xor zero
        if(it->second.size()>1)
        {
            long long int si=it->second.size();
            
            //get the maximum size subarray possible
            long long int dif=(it->second[si-1])-(it->second[0]);
            if(dif>1)
            {
                ans=max(ans,dif);
            }
        }
    }
 
    cout<<ans;
 
}