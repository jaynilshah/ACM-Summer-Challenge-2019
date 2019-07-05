#include<iostream>
#include<string>

using namespace std;

int main() {

//	freopen("input_10.txt", "r", stdin);
//	freopen("output_10.txt", "w", stdout);

    string str;
    int l;
    getline(cin, str);
    l = str.length();
    for(int i=0; i<l; i++) {
    	if(str.at(i) == ' ') cout<<"\\";
    	else cout<<str.at(i);
    }
    return 0;
}
