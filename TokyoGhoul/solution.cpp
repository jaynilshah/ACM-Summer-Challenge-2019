#include<bits/stdc++.h>
using namespace std;
int main()
{

    long long int t;
    cin>>t;
    while(t--)
    {
        long long int n,k,i;
        cin>>n>>k;

        //using multiset as priority_queue
        multiset<long long int,greater<long long int> > ms;
        for(i=0;i<n;i++)
        {
            long long int y;
            cin>>y;
            ms.insert(y);
        }
        long long int tt=1;
        while(k--)
        {
            //if we can have fight or not
            if(ms.size()==0)
            {
                tt=0;
                break;
            }
 
            long long int x=*ms.begin();
            ms.erase(ms.begin());
            
            for(i=2;i<=sqrt(x);i++)
            {
                if(x%i==0)
                {
                    ms.insert(i);
                    if(i*i!=x)
                    {
                        ms.insert(x/i);
                    }
                }
            }
        }
 
        if(tt==0)
            cout<<"It was easy!!\n";
        else
            cout<<ms.size()<<"\n";
    }
}