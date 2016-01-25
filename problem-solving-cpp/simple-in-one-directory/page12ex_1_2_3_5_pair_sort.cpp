#include <stdio.h>
#include <vector>       // std::vector
#include <utility>      // std::pair, std::make_pair
#include <algorithm>    // std::sort
using namespace std;

typedef pair<int, int> ii; // we will utilize the natural sort order
typedef pair<ii, int> iii; // of the primitive data types that we paired

int main() {
	iii A = make_pair(ii(5, 24), -1982); // reorder DD/MM/YYYY
	iii B = make_pair(ii(5, 24), -1980); // to MM, DD,
	iii C = make_pair(ii(11, 13), -1983); // and then use NEGATIVE YYYY	
	
	vector<iii> birthdays;
	
	birthdays.push_back(A); 
	birthdays.push_back(B); 
	birthdays.push_back(C);

	sort(birthdays.begin(), birthdays.end()); // that’s all :)

	for (int i = 0; i < (int)birthdays.size(); i++) printf("%d.%d.%d\n", birthdays[i].first.first, birthdays[i].first.second, -birthdays[i].second);
}