 #include<bits/stdc++.h>
    using namespace std;
    int main()
    {
        long long int n,k,i;
        cin>>n>>k;
        
        vector<long long int> v;
        for(i=0;i<n;i++)
        {
            long long int y;
            cin>>y;
            v.push_back(y);
        }
        
        long long int dif=INT_MIN;
        long long int ma=v[n-1];
        
        for(i=n-2;i>=0;i--)
        {
            if(v[i]<ma)
            {
                dif=max(dif,ma-v[i]);
            }
            else
            {
                ma=v[i];
            }
        }
        
        if(dif==INT_MIN)
            cout<<0;
        else
            cout<<dif*k;
    }
