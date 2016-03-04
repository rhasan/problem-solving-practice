#include <stdio.h>
#include <vector>       // std::vector
#include <utility>      // std::pair, std::make_pair
#include <algorithm>    // std::sort
using namespace std;

#define ALL(x) x.begin(), x.end()
#define COUNTOF(x) (sizeof(x)/sizeof(*x))

int main() {
	int myints[] = {11, 12, 2, 22, 3, 300, 42, 32, 1}; 
	int n = COUNTOF(myints);
	int x = 22;

	sort(myints, myints+n);
	bool found  = binary_search(myints, myints+n, x);

	printf("%d\n", found);

}
