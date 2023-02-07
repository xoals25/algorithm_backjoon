#include <iostream>
#include <vector>
using namespace std;
typedef long long ll;

struct edge {
	int x, y; ll d;
	edge(int x, int y, ll d) {
		this->x = x, this->y = y, this->d = d;
	}
};

ll dist[1001];
vector<edge> edges;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, K; cin >> N >> K;
	
	for (int i = 1; i <= N; i++) {
		edges.emplace_back(i, 0, 0);
		edges.emplace_back(0, i, 100);
	}
	for (int i = 0; i < K; i++) {
		int q, x, y, d; cin >> q >> x >> y >> d;
		if (q == 1) edges.emplace_back(edge(x, y, -d));
		else if (q == 2) edges.emplace_back(edge(y, x, d));
		else {
			edges.emplace_back(edge(x, y, -d));
			edges.emplace_back(edge(y, x, d));
		}
	}

	for (int i = 1; i <= N; i++) dist[i] = 1000000007;
	for (int i = 0; i < N; i++) {
		for (auto &e : edges) {
			if (dist[e.x] < 1000000007) dist[e.y] = min(dist[e.y], dist[e.x] + e.d);
		}
	}

	bool chk = 1;
	for (auto& e : edges) {
		if (dist[e.x] < 1000000007) {
			if (dist[e.y] > dist[e.x] + e.d) chk = 0;
		}
	}

	if (chk) {
		ll mn = 100;
		for (int i = 1; i <= N; i++) mn = min(mn, dist[i]);
		cout << 100 - mn;
	}
	else cout << -1;
}