#include<bits/stdc++.h>
using namespace std;
int main()
{
 
    long long int n,i;
    cin>>n;
 
    vector<long long int > v(n),odd,even;
    long long int minodd=100005,oddidx=100005,o=0,e=0;
    long long int mineven=100005,evenidx=100005;


    for(i=0;i<n;i++)
    {
        long long int y;
        cin>>y;
        if(i%2==0)
        {
            //store element at odd index 
            odd.push_back(y);
            //get the minimum value and index at odd places
            if(y<minodd)
            {
                minodd=y;
                oddidx=o;
            }
            o++;
        }
        else
        {
            //store element at even index
            even.push_back(y);
            //get the minimum value and index at even places
            if(y<mineven)
            {
                mineven=y;
                evenidx=e;
            }
            e++;
        }
    }
 

    long long int oddsi=odd.size();
    long long int evensi=even.size();
  
    //filling elements at odd index 
    long long int j=0;
    for(i=oddidx;i<oddsi;i++)
    {
        v[j]=odd[i];
        j=j+2;
    }
 
    for(i=0;i<oddidx;i++)
    {
        v[j]=odd[i];
        j=j+2;
    }
 
    //filling elements at even index
    j=1;
    for(i=evenidx;i<evensi;i++)
    {
        v[j]=even[i];
        j=j+2;
    }
    for(i=0;i<evenidx;i++)
    {
        v[j]=even[i];
        j=j+2;
    }
 
    //check if we obtained sorted array
    long long int test=1;
    for(i=0;i<n-1;i++)
    {
        if(v[i]>v[i+1])
        {
            test=0;
            break;
        }
    }
 
    if(test==0)
    {
        cout<<"NO";
    }
    else
    {
        cout<<"YES\n";
        cout<<min(oddidx,oddsi-oddidx)+min(evenidx,evensi-evenidx);
    }
 
 
}