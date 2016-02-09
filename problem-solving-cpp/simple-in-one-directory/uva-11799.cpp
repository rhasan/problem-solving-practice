#include <stdio.h>
#include <limits>       // std::numeric_limits
using namespace std;

int main() {
	int T, N, c, max;
	int NEG_INF = numeric_limits<int>::min();

	scanf("%d", &T);

	for(int tc = 1; tc <= T; tc++) {
		scanf("%d", &N);
		max = NEG_INF;
		for(int i = 0; i < N; i++) {
			scanf("%d", &c);
			if(max < c) {
				max = c;
			}
		}
		printf("Case %d: %d\n", tc, max);
	}

	return 0;
}
