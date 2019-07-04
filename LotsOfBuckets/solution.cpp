#include<bits/stdc++.h>
using namespace std;
 //refer with editorial
int main()
{
 
    long long int n,i;
    cin>>n;
 
    vector<long long int> v;
    multiset<long long int> m;
 
    for(i=0;i<n;i++)
    {
        long long int y;
        cin>>y;
        v.push_back(y);
        m.insert(y);
    }
 
 
    long long int ans=n;
    sort(v.begin(),v.end());
 
    if(n%2==0)
        n--;

    //check for elements of group 1
    for(i=n/2;i>=0;i--)
    {
        long long int x=v[i];
        //check if v[i] can be hold by any bucket 
        if(m.lower_bound(2*x)!=m.end())
        {
            //if yes we remove v[i] and the bucket holding it,so we
            m.erase(m.find(x));
            m.erase(m.lower_bound(2*x));
            ans--;
        }
    }
 
    cout<<ans;
}