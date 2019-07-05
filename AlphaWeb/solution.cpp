#include<iostream>
#include<cmath>

using namespace std;

int main() {

//    freopen("in09.txt", "r", stdin);
//    freopen("out09.txt", "w", stdout);

    int n;
    cin>>n;

    for(int i=0; i<2*n-1; i++) {
        for(int j=0; j<2*n-1; j++) {
            if(i == j || i+j == 2*n-2 || j == n-1) {
                int diff = abs(n-1-i);
                char c = 'A' + diff;
                cout<<c;
            }
            else if(i == n-1) {
                int diff = abs(n-1-j);
                char c = 'A' + diff;
                cout<<c;
            }
            else cout<<" ";
        }
        if(i != 2*n-2) cout<<endl;
    }

    return 0;
}
