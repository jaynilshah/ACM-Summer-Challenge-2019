#include <bits/stdc++.h>

using namespace std;

int main() {
//    freopen("in09.txt", "r", stdin);
//    freopen("out09.txt", "w", stdout);

    vector<vector<int> > b1(5, vector<int>(5)), b2(5, vector<int>(5));
    vector<vector<bool> > marked1(5, vector<bool>(5, false)), marked2(5, vector<bool>(5, false));
    vector<int> seq(25);
    int max1 = 0, max2 = 0;

    // input first board
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            cin >> b1[i][j];
        }
    }

    // input second board
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            cin >> b2[i][j];
        }
    }

    // input sequence
    for (int i = 0; i < 25; i++) {
        cin >> seq[i];
    }

    int ind = 0;

    // simulate
    while (max1 < 5 && max2 < 5) {
        // find in first board
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (b1[i][j] == seq[ind]) marked1[i][j] = true;
            }
        }
        // find in second board
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (b2[i][j] == seq[ind]) marked2[i][j] = true;
            }
        }
        // check horizontal rows
        for (int i = 0; i < 5; i++) {
            int temp1 = 0, temp2 = 0;
            for (int j = 0; j < 5; j++) {
                if (marked1[i][j]) temp1++;
                if (marked2[i][j]) temp2++;
            }
            if (temp1 > max1) max1 = temp1;
            if (temp2 > max2) max2 = temp2;
        }
        // check vertical columns
        for (int i = 0; i < 5; i++) {
            int temp1 = 0, temp2 = 0;
            for (int j = 0; j < 5; j++) {
                if (marked1[j][i]) temp1++;
                if (marked2[j][i]) temp2++;
            }
            if (temp1 > max1) max1 = temp1;
            if (temp2 > max2) max2 = temp2;
        }
        // check primary diagonal
        int temp1 = 0, temp2 = 0;
        for (int i = 0, j = 0; i < 5 && j < 5; i++, j++) {
            if (marked1[i][j]) temp1++;
            if (marked2[i][j]) temp2++;
        }
        if (temp1 > max1) max1 = temp1;
        if (temp2 > max2) max2 = temp2;

        // check secondary diagonal
        temp1 = 0, temp2 = 0;
        for (int i = 0, j = 4; i < 5 && j >= 0; i++, j--) {
            if (marked1[i][j]) temp1++;
            if (marked2[i][j]) temp2++;
        }
        if (temp1 > max1) max1 = temp1;
        if (temp2 > max2) max2 = temp2;
        cout << max1 << " " << max2 << endl;
        ind++;
    }
    if (max1 > max2 && max1 == 5)
        cout << "I Won!";
    else if (max2 > max1 && max2 == 5)
        cout << "You won -_-";
    else if (max1 == max2 && max1 == 5)
        cout << "It's a tie!";
    else
        return -1;

    return 0;
}
