```Cpp
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int maxActivities(vector<pair<int, int>>& intervals) {
    // Sort based on end time using lambda comparator
    sort(intervals.begin(), intervals.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
        return a.second < b.second;
    });

    int count = 0;
    int end = -1;

    for (const auto& interval : intervals) {
        if (interval.first > end) {
            count++;
            end = interval.second;
        }
    }

    return count;
}

int main() {
    vector<pair<int, int>> intervals = { {1, 3}, {2, 4}, {3, 5} };
    cout << maxActivities(intervals) << endl; // Output: 2
    return 0;
}

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int findContentChildren(vector<int>& greed, vector<int>& size) {
    sort(greed.begin(), greed.end());
    sort(size.begin(), size.end());

    int i = 0, j = 0;
    while (i < greed.size() && j < size.size()) {
        if (size[j] >= greed[i]) {
            i++;
        }
        j++;
    }
    return i;
}

int main() {
    vector<int> greed = {1, 2, 3};
    vector<int> size = {1, 1};
    
    cout << findContentChildren(greed, size) << endl; // Expected: 1
    return 0;
}

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Request {
    int start, end, bandwidth;
    Request(int s, int e, int b) : start(s), end(e), bandwidth(b) {}
};

int allocate(vector<Request>& requests, int capacity) {
    // Sort requests by end time
    sort(requests.begin(), requests.end(), [](const Request& a, const Request& b) {
        return a.end < b.end;
    });

    // Simulate a timeline (max time assumed 1000)
    vector<int> timeline(1001, 0);

    for (const auto& r : requests) {
        bool canAllocate = true;

        for (int i = r.start; i < r.end; ++i) {
            if (timeline[i] + r.bandwidth > capacity) {
                canAllocate = false;
                break;
            }
        }

        if (canAllocate) {
            for (int i = r.start; i < r.end; ++i) {
                timeline[i] += r.bandwidth;
            }
        }
    }

    // Find max bandwidth used at any point in time
    int used = 0;
    for (int bw : timeline) {
        used = max(used, bw);
    }

    return used;
}

int main() {
    vector<Request> req = {
        Request(1, 4, 3),
        Request(2, 6, 4),
        Request(5, 7, 2)
    };

    cout << allocate(req, 5) << endl; // Expected Output: 5
    return 0;
}
#include <iostream>
#include <string>

using namespace std;

int minSwaps(const string& s) {
    int open = 0, unbalanced = 0;

    for (char c : s) {
        if (c == '[') {
            open++;
        } else {
            if (open > 0) {
                open--;
            } else {
                unbalanced++;
            }
        }
    }

    return (unbalanced + 1) / 2;
}

int main() {
    cout << minSwaps("][][") << endl; // Expected: 1
    return 0;
}
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int minCost(vector<int>& prices, int k) {
    sort(prices.begin(), prices.end());

    int cost = 0;
    int n = prices.size();

    // We buy prices[i] for the first (n - i / (k+1)) elements
    for (int i = 0; i < n - i / (k + 1); ++i) {
        cost += prices[i];
    }

    return cost;
}

int main() {
    vector<int> prices = {3, 2, 1, 4};
    cout << minCost(prices, 1) << endl; // Output: 6 (buy 1, 2, 3; get 4 free)
    return 0;
}
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int maxCandies(vector<int>& prices, int vouchers) {
    sort(prices.begin(), prices.end());

    int total = 0;
    for (int i = 0; i < prices.size() && vouchers >= prices[i]; ++i) {
        vouchers -= prices[i];
        total++;
    }

    return total;
}

int main() {
    vector<int> prices = {1, 2, 3, 4, 5};
    int vouchers = 10;

    cout << maxCandies(prices, vouchers) << endl; // Expected: 4
    return 0;
}
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int maxDisjointSubstrings(const string& s) {
    int n = s.length(), count = 0, i = 0;

    while (i < n) {
        vector<int> freq(26, 0);
        int j = i;
        while (j < n && ++freq[s[j++] - 'a'] <= 1);
        count++;
        i = j;
    }

    return count;
}

int main() {
    cout << maxDisjointSubstrings("abac") << endl; // Expected: 2 ("ab", "ac")
    return 0;
}
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Item {
    int value, weight;
    Item(int v, int w) : value(v), weight(w) {}
};

// Comparator to sort items by value-to-weight ratio (descending)
bool cmp(const Item& a, const Item& b) {
    return (double)a.value / a.weight > (double)b.value / b.weight;
}

double getMaxValue(vector<Item>& items, int W) {
    sort(items.begin(), items.end(), cmp);

    double total = 0.0;

    for (const auto& item : items) {
        if (W >= item.weight) {
            W -= item.weight;
            total += item.value;
        } else {
            total += (double)item.value * W / item.weight;
            break;
        }
    }

    return total;
}

int main() {
    vector<Item> items = {
        Item(60, 10),
        Item(100, 20),
        Item(120, 30)
    };

    int capacity = 50;
    cout << getMaxValue(items, capacity) << endl; // Expected: 240.0

    return 0;
}
#include <iostream>
#include <vector>
#include <climits>

using namespace std;

pair<int, int> findTwoLargest(const vector<int>& arr) {
    int max1 = INT_MIN, max2 = INT_MIN;

    for (int num : arr) {
        if (num > max1) {
            max2 = max1;
            max1 = num;
        } else if (num > max2 && num != max1) {
            max2 = num;
        }
    }

    return {max1, max2};
}

int main() {
    vector<int> arr = {10, 20, 4, 45, 99};
    auto [largest, secondLargest] = findTwoLargest(arr);

    cout << "Largest: " << largest << ", Second Largest: " << secondLargest << endl;
    return 0;
}
#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

int maxDishes(const vector<int>& dishes, int maxType) {
    unordered_map<int, int> freq;
    int left = 0, maxLen = 0;

    for (int right = 0; right < dishes.size(); ++right) {
        freq[dishes[right]]++;

        while (freq.size() > maxType) {
            freq[dishes[left]]--;
            if (freq[dishes[left]] == 0) {
                freq.erase(dishes[left]);
            }
            left++;
        }

        maxLen = max(maxLen, right - left + 1);
    }

    return maxLen;
}

int main() {
    vector<int> dishes = {1, 2, 1, 3, 4, 2, 3};
    int maxType = 2;

    cout << maxDishes(dishes, maxType) << endl; // Expected: 4 ("1,2,1,3" or "4,2,3")
    return 0;
}
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int maxMeetings(const vector<int>& start, const vector<int>& end) {
    int n = start.size();
    vector<pair<int, int>> meetings;

    for (int i = 0; i < n; ++i) {
        meetings.emplace_back(start[i], end[i]);
    }

    // Sort by end time
    sort(meetings.begin(), meetings.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
        return a.second < b.second;
    });

    int count = 0, lastEnd = 0;
    for (const auto& m : meetings) {
        if (m.first > lastEnd) {
            count++;
            lastEnd = m.second;
        }
    }

    return count;
}

int main() {
    vector<int> start = {1, 3, 0, 5, 8, 5};
    vector<int> end   = {2, 4, 6, 7, 9, 9};

    cout << maxMeetings(start, end) << endl; // Expected: 4
    return 0;
}

#include <iostream>
#include <vector>
#include <queue>
#include <functional>

using namespace std;

int minMergeCost(const vector<int>& files) {
    // Min-heap using priority_queue with greater<int>
    priority_queue<int, vector<int>, greater<int>> pq(files.begin(), files.end());

    int cost = 0;

    while (pq.size() > 1) {
        int a = pq.top(); pq.pop();
        int b = pq.top(); pq.pop();

        cost += a + b;
        pq.push(a + b);
    }

    return cost;
}

int main() {
    vector<int> files = {4, 8, 6, 12};
    cout << minMergeCost(files) << endl; // Expected: 58
    return 0;
}


#include <iostream>
#include <vector>
#include <queue>
#include <functional>

using namespace std;

int minMergeCost(const vector<int>& files) {
    // Min-heap using priority_queue with greater<int>
    priority_queue<int, vector<int>, greater<int>> pq(files.begin(), files.end());

    int cost = 0;

    while (pq.size() > 1) {
        int a = pq.top(); pq.pop();
        int b = pq.top(); pq.pop();

        cost += a + b;
        pq.push(a + b);
    }

    return cost;
}

int main() {
    vector<int> files = {4, 8, 6, 12};
    cout << minMergeCost(files) << endl; // Expected: 58
    return 0;
}


#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int assignMice(vector<int>& mice, vector<int>& holes) {
    sort(mice.begin(), mice.end());
    sort(holes.begin(), holes.end());

    int maxDist = 0;
    for (size_t i = 0; i < mice.size(); ++i) {
        maxDist = max(maxDist, abs(mice[i] - holes[i]));
    }

    return maxDist;
}

int main() {
    vector<int> mice = {4, -4, 2};
    vector<int> holes = {4, 0, 5};

    cout << assignMice(mice, holes) << endl; // Expected: 4
    return 0;
}
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int minCoins(vector<int>& coins, int amount) {
    sort(coins.begin(), coins.end()); // Sort in ascending order
    int count = 0;

    for (int i = coins.size() - 1; i >= 0 && amount > 0; --i) {
        count += amount / coins[i];
        amount %= coins[i];
    }

    return count;
}

int main() {
    vector<int> coins = {1, 2, 5, 10};
    int amount = 27;

    cout << minCoins(coins, amount) << endl; // Expected: 4 (10+10+5+2)
    return 0;
}
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int findPlatforms(vector<int>& arr, vector<int>& dep) {
    sort(arr.begin(), arr.end());
    sort(dep.begin(), dep.end());

    int plat_needed = 0, maxPlat = 0;
    int i = 0, j = 0;
    int n = arr.size();

    while (i < n && j < n) {
        if (arr[i] <= dep[j]) {
            plat_needed++;
            i++;
            maxPlat = max(maxPlat, plat_needed);
        } else {
            plat_needed--;
            j++;
        }
    }

    return maxPlat;
}

int main() {
    vector<int> arr = {900, 940, 950, 1100, 1500, 1800};
    vector<int> dep = {910, 1200, 1120, 1130, 1900, 2000};

    cout << findPlatforms(arr, dep) << endl; // Expected: 3
    return 0;
}
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int minRemovals(vector<int>& strengths, int limit) {
    int sum = 0;
    for (int s : strengths) {
        sum += s;
    }

    sort(strengths.begin(), strengths.end(), greater<int>()); // Remove strongest first

    int count = 0;
    for (int i = 0; i < strengths.size() && sum > limit; ++i) {
        sum -= strengths[i];
        count++;
    }

    return count;
}

int main() {
    vector<int> villains = {4, 2, 1, 10};
    int limit = 10;

    cout << minRemovals(villains, limit) << endl; // Expected: 2 (remove 10, then 4)
    return 0;
}
#include <iostream>
#include <unordered_map>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int maxSubstrings(const string& s) {
    unordered_map<char, int> first, last;

    for (int i = 0; i < s.length(); ++i) {
        if (first.find(s[i]) == first.end()) {
            first[s[i]] = i;
        }
        last[s[i]] = i;
    }

    vector<pair<int, int>> ranges;

    for (const auto& [c, start] : first) {
        int end = last[c];
        int j = start;
        while (j <= end) {
            end = max(end, last[s[j]]);
            ++j;
        }
        ranges.emplace_back(start, end);
    }

    sort(ranges.begin(), ranges.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
        return a.second < b.second;
    });

    int count = 0, prevEnd = -1;
    for (const auto& [start, end] : ranges) {
        if (start > prevEnd) {
            count++;
            prevEnd = end;
        }
    }

    return count;
}

int main() {
    string s = "adefaddaccc";
    cout << maxSubstrings(s) << endl; // Expected: 3
    return 0;
}

```