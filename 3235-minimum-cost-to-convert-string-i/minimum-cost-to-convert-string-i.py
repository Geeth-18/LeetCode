class Solution:
    def minimumCost(self, source, target, original, changed, cost):
        inf = float('inf')
        dist = [[inf] * 26 for _ in range(26)]
        
        for i in range(26):
            dist[i][i] = 0
            
        for u, v, w in zip(original, changed, cost):
            u_idx = ord(u) - ord('a')
            v_idx = ord(v) - ord('a')
            dist[u_idx][v_idx] = min(dist[u_idx][v_idx], w)
            
        for k in range(26):
            for i in range(26):
                for j in range(26):
                    if dist[i][k] + dist[k][j] < dist[i][j]:
                        dist[i][j] = dist[i][k] + dist[k][j]
        
        total_cost = 0
        for s_char, t_char in zip(source, target):
            if s_char != t_char:
                char_cost = dist[ord(s_char) - ord('a')][ord(t_char) - ord('a')]
                if char_cost == inf:
                    return -1
                total_cost += char_cost
                
        return total_cost
        