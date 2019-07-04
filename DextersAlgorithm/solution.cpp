#include<bits/stdc++.h>
using namespace std;
long long int n,max_value=INT_MIN;
vector<long long int> v;

void countsort(long long int expo)
{
    long long int ct[10000]={0},i;
    vector<long long int> op(n);
 
    for(i=0;i<n;i++)
    {
        ct[(v[i]/expo)%10000]++;
    }
 
    for(i=1;i<=9999;i++)
        ct[i]+=ct[i-1];
 
    for(i=n-1;i>=0;i--)
    {
        op[--ct[(v[i]/expo)%10000]]=v[i];
    }
 
    for(i=0;i<n;i++)
    {
        v[i]=op[i];
        cout<<v[i]<<" ";
    }
    cout<<"\n";
 
}
 
void radixsort()
{
    for(long long int i=1;max_value/i>0;i=i*10000)
    {
        countsort(i);
    }
}
 
int main()
{
 
    cin>>n;
    for(long long int i=0;i<n;i++)
    {
        long long int y;
        cin>>y;
        v.push_back(y);
        max_value=max(max_value,y);
    }
 
    radixsort();
}