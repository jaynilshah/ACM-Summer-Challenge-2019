#include<bits/stdc++.h>
using namespace std;
int main()
{
    
 
    long long int n,k,i;
    cin>>n>>k;
 
    map<char,long long int> mp;
 
    //store frequency of each character
    for(i=0;i<n;i++)
    {
        char c;
        cin>>c;
        mp[c]++;
    }
 
    //stores the palindromic string
    char palindrome[k];
 
    long long int test=0;
    long long int ct=0,idx=0;
 
    map<char,long long int>::iterator it;
    //start with smallest possible alphabet available
    for(it=mp.begin();it!=mp.end();it++)
    {
        long long int total_char=it->second;
        char alphabet=it->first;
 
        if(total_char>1)
        {
            //fill using the current character till we can
            for(;idx<k/2&&total_char>1;idx++)
            {
                palindrome[idx]=alphabet;
                palindrome[k-1-idx]=alphabet;
                total_char-=2;
                ct+=2;
            }
        }
        //if we still have the current alphabet left then use it to fill the middle of palindrome if of odd length
        if(k%2!=0&&test==0&&total_char>=1)
        {
            palindrome[k/2]=alphabet;
            total_char--;
            test=1;
            ct+=1;
        }
 
    }
 
    if(ct!=k)
    {
        cout<<"NO";
    }
    else
    {
        cout<<"YES\n";
        for(i=0;i<k;i++)
        {
            cout<<palindrome[i];
 
        }
    }
}