#include <stdio.h>
#define MAX_N 20

int main() {
	int test_cases, n, p, b, bars[MAX_N];
	//freopen ("12455.in","r",stdin);
	scanf("%d",&test_cases);
	//printf("%d\n", test_cases);

	for(int tc = 0; tc < test_cases; tc++) {
		scanf("%d", &n);
		scanf("%d", &p);
		for(int cp = 0; cp < p; cp++) {
			scanf("%d", &b);
			bars[cp] = b;
			//printf("%d ", b);
		}
		bool found = false;
		for(int i = 0; i < (1 << p); i++) {
			int sum = 0;
			for(int j = 0; j < p; j++) {
				if(i & (1 << j)) {
					sum += bars[j];
				}
			}
			if(sum == n) {
				found = true;
				break;
			}
		}
		if(found)
			printf("YES\n");
		else
			printf("NO\n");

		//printf("\n");
	}
}
