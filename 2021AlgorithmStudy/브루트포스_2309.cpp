#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;


// 이 코드는 나머지 8,9 번째 숫자로 비교하기 때문에 7개로 나오지 않는경우 발생
//EX) 10 1 2 3 4 5 6 7 72
//int main() {
//	vector<int> height;
//	int x;
//
//	for (int i = 0; i < 9; i++) {
//		cin >> x;
//		height.push_back(x);
//	}
//
//	sort(height.begin(), height.end());
//
//	int r = 100;
//
//	for (int i = 0; i < 7; i++) {
//		r -= height[i];
//	}
//
//	if (r == 0)
//		for (int i = 0; i < 7; i++)
//			cout << height[i] << "\n";
//
//	else {
//		bool flag = false;
//
//		int n1 = height[7] - r;
//		int n2 = height[8] - r;
//
//		for (int i = 0; i < 7; i++) {
//			if (n1 == height[i]) {
//				height[i] = -1;
//				height[8] = -1;
//				flag = true;
//				break;
//			}
//		}
//
//		if (!flag) {
//			for (int i = 0; i < 7; i++) {
//				if (n2 == height[i]) {
//					height[i] = -1;
//					height[7] = -1;
//					break;
//				}
//			}
//		}
//
//		sort(height.begin(), height.end());
//
//		for (int i = 2; i < 9; i++)
//			cout << height[i] << "\n";
//
//	}
//}

//그래서 모든 입력들의 합과 100의 차이로 구하기
int main() {
	vector<int> height;
	int x;
	int sum = 0;

	for (int i = 0; i < 9; i++) {
		cin >> x;
		sum += x;
		height.push_back(x);
	}

	sum -= 100;

	sort(height.begin(), height.end());

	bool flag = true;

	for (int i = 0; i < 9; i++) {
		for (int j = i + 1; j < 9; j++) {
			int n = height[i] + height[j];
			if (n == sum) {
				height[i] = -1;
				height[j] = -1;
				flag = false;
				break;
			}
		}
		if (!flag)
			break;
	}

	sort(height.begin(), height.end());

	for (int i = 2; i < 9; i++)
		cout << height[i] << "\n";
}