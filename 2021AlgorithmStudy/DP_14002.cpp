#include<iostream>
#include<vector>

using namespace std;

int main() {
    int N;
    int nums[1001], DP[1001];
    vector<int> tmp[1001];
    vector<int> result;

    cin >> N;

    for (int i = 0; i < N; i++)
        cin >> nums[i];

    for (int i = 0; i < N; i++) {
        DP[i] = 1;
        tmp[i].push_back(nums[i]);

        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
                if (DP[i] < DP[j] + 1) {
                    //���� ������ �ֱ⶧����
                    tmp[i].clear(); // ���� ���� ���ڸ� �����
                    //���� ������ �ְ�
                    tmp[i] = tmp[j];
                    //���� ���� �ֱ�
                    tmp[i].push_back(nums[i]);
                    DP[i] = DP[j] + 1;
                }
            }
        }
        if (result.size() < tmp[i].size())
            result = tmp[i];
    }

    cout << result.size() << "\n";

    for (int i = 0; i < result.size(); i++)
        cout << result[i] << " ";

    cout << "\n";
}