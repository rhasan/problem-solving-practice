#include <stdio.h>
#include <algorithm>    // std::sort
using namespace std;

int main() {
	int k, sal[3];

	scanf("%d",&k);
	for(int i = 0; i < k; i++) {
		scanf("%d%d%d",&sal[0],&sal[1],&sal[2]);
		sort(sal, sal+3);
		printf("Case %d: %d\n", i+1, sal[1]);
	}
}