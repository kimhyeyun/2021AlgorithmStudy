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

	//next_permutation : 다음 순열
	//prev_permutation : 이전 순열

	//처음에 기본 while문으로 순열을 바로 만드니 맨처음 순열은 검사를 하지않아 틀림
	//do~while이나 while문 전에 한번 검사해야함
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