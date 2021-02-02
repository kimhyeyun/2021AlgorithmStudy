#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

vector<char> ja;
vector<char> mo;
vector<string> amho;
int L, C;

void Solve(int idxm, int idxj,int cntm, int cntj, string s) {
	//암호의 길이가 L이고 자음이 두개이상, 모음이 하나이상
	if (s.length()== L &&cntm >= 1 && cntj >= 2) {
		bool flag = false;
		sort(s.begin(), s.end());
		for (int i = 0; i < amho.size(); i++) {
			if (amho[i] == s) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			amho.push_back(s);
		}
		
		return;
	}

	//길이만 같으면 그냥 뺌
	if (s.length() == L)
		return;


	for (int j = idxj; j < ja.size(); j++)	
		Solve(idxm, j+1,cntm, cntj+1, s + ja[j]);		
	for (int m = idxm; m < mo.size(); m++)
		Solve(m+1, idxj, cntm+1, cntj, s + mo[m]);
}

int main() {
	cin >> L >> C;

	while (C--) {
		char x;
		cin >> x;
		if (x == 'a' || x == 'e' || x == 'o' || x == 'u' || x == 'i')
			mo.push_back(x);
		else
			ja.push_back(x);
	}

	sort(ja.begin(), ja.end());
	sort(mo.begin(), mo.end());

	Solve(0, 0, 0, 0, "");
	sort(amho.begin(), amho.end());

		for (int i = 0; i < amho.size(); i++) {
		cout << amho[i] << "\n";
	}
}
