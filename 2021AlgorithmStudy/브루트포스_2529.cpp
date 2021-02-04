#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int K;
char vudengho[10];

bool check(vector<int> tmp) {
	for (int i = 0; i < K; i++) {
		if (vudengho[i] == '<' && tmp[i] > tmp[i + 1])
			return false;
		if (vudengho[i] == '>' && tmp[i] < tmp[i + 1])
			return false;
	}
	return true;
}

int main() {
	vector<int> max, min;

	cin >> K;
	
	for (int i = 0; i < K; i++)
		cin >> vudengho[i];

	for (int i = 0; i <= K; i++) {
		max.push_back(9 - i);
		min.push_back(i);
	}

	//next_permutation : ���� ����
	//prev_permutation : ���� ����

	//ó���� �⺻ while������ ������ �ٷ� ����� ��ó�� ������ �˻縦 �����ʾ� Ʋ��
	//do~while�̳� while�� ���� �ѹ� �˻��ؾ���
	do {
		if (check(max))
			break;
	} while (prev_permutation(max.begin(), max.end()));

	do {
		if (check(min))
			break;
	} while (next_permutation(min.begin(), min.end()));

	for (int i = 0; i < max.size(); i++)
		cout << max[i];

	cout << "\n";

	for (int i = 0; i < min.size(); i++)
		cout << min[i];


}