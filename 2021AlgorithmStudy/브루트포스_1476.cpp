#include<iostream>
using namespace std;

// ��ȿ���������� ���Ʈ ���� �˰����� �̿��Ͽ� Ǯ���ϴ� 
// �����̹Ƿ� �⵵�� �����ϸ鼭 15, 28, 19�� ���� ��� ã��

int main() {
	int E, S, M;
	
	cin >> E >> S >> M;

	int year = 1;

	while (1) {
		if ((year - E) % 15 == 0 && (year - S) % 28 == 0 && (year - M) % 19 == 0)
			break;
		year++;
	}

	cout << year << "\n";
}