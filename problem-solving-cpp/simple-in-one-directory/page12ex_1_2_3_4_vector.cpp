#include <stdio.h>
#include <algorithm>    // std::unique, std::distance
#include <vector>       // std::vector
using namespace std;

#define ALL(x) x.begin(), x.end()
#define UNIQUE(c) (c).resize(unique(ALL(c)) - (c).begin())

#define COUNTOF(x) (sizeof(x)/sizeof(*x))

int main() {
	int myints[] = {1, 2, 2, 2, 3, 3, 2, 2, 1};
	int size = COUNTOF(myints);
	vector<int> v(myints, myints+size);
	sort(ALL(v));
	UNIQUE(v);
	for (int i = 0; i < (int)v.size(); i++) printf("%d\n", v[i]);
}