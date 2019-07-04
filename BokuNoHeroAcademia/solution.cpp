#include<bits/stdc++.h>
using namespace std;
int main()
{
    
 
    long long int n,q,i,j;
    cin>>n>>q;
 
    vector<long long int>a,b;
 
    for(i=0;i<n;i++)
    {
        long long int y;
        cin>>y;
        a.push_back(y);
    }
 
    for(i=0;i<n;i++)
    {
        long long int y;
        cin>>y;
        b.push_back(y);
    }
    
    //this container stores all possible pairs for a fraction
    map<pair<long long int,long long int>,vector<pair<long long int,long long int> > > mp;
 
    //making all possible fraction
    for(i=0;i<n;i++)
    {
        for(j=0;j<n;j++)
        {
            //storing answer in simplest fraction
            long long int xx=__gcd(a[i],b[j]);
            mp[{a[i]/xx,b[j]/xx}].push_back({a[i],b[j]});
        }
    }
    
    //this sorting helps to get the kth smallest pair
    map<pair<long long int,long long int>,vector<pair<long long int,long long int> > >::iterator it;
    for(it=mp.begin();it!=mp.end();it++)
    {
        sort(it->second.begin(),it->second.end());
    }
 
    while(q--)
    {
        long long int c,d,k;
        cin>>c>>d>>k;
        long long int xx=__gcd(c,d);
        c/=xx;
        d/=xx;
        
        //check if that fraction had atleast k pairs
        long long int si=mp[{c,d}].size();
        if(si<k)
        {
            cout<<"NIE\n";
        }
        else
        {
            cout<<mp[{c,d}][k-1].first<<" "<<mp[{c,d}][k-1].second<<"\n";
        }
    }
 
 
}