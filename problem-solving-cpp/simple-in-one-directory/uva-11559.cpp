#include <stdio.h>
#include <limits>       // std::numeric_limits
using namespace std;
int main() {
	int n, b, h, w, p, a;
	int min_price, price;
	int INF = numeric_limits<int>::max();
	bool found_hotel;

	while(scanf("%d%d%d%d",&n, &b, &h, &w) != EOF) {
		min_price = INF;
		found_hotel = false;
		for(int i = 0; i < h; i++) {
			scanf("%d", &p);
			price = 0;
			for(int j = 0; j < w; j++) {
				scanf("%d", &a);
				if(a >= n) {
					price = n * p;
					found_hotel = true;
					if(price < min_price) {
						min_price = price;
					}
				}
			}
		}
		if(found_hotel && min_price <= b) {
			printf("%d\n", min_price);
		} else {
			printf("stay home\n");
		}
	}

	return 0;
}
