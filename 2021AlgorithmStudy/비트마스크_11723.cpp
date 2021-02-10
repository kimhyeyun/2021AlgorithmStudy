#include<iostream>
#include<vector>
using namespace std;

class Set {
public:
	vector<int> s;
	int x, idx;

	bool find(int x) {
		for (int i = 0; i < s.size(); i++) {
			if (s[i] == x) {
				idx = i;
				return true;
			}
		}
		return false;
	}

	void add(int x) {
		if (!find(x)) {
			s.push_back(x);
		}
	}

	void remove(int x) {
		if (find(x)) {
			s.erase(s.begin() + idx);
		}
	}

	int check(int x) {
		if (find(x))
			return 1;
		else
			return 0;
	}

	void toggle(int x) {
		if (find(x)) {
			s.erase(s.begin() + idx);
		}
		else
			s.push_back(x);
	}

	void empty() {
		s.erase(s.begin(), s.end());
	}

	void all() {
		empty();
		for (int i = 1; i <= 20; i++)
			s.push_back(i);
	}
};

int main() {
	int M;
	Set set;

	cin >> M;

	while (M--) {
		string s;

		cin >> s;

		if (s == "add") {
			int x;
			cin >> x;
			set.add(x);
		}

		else if (s == "remove") {
			int x;
			cin >> x;
			set.remove(x);
		}

		else if (s == "empty")
			set.empty();

		else if (s == "toggle") {
			int x;
			cin >> x;
			set.toggle(x);
		}

		else if (s == "check") {
			int x;
			cin >> x;
			cout << set.check(x) << "\n";
		}

		else if (s == "all")
			set.all();
	}
}