class Solution:
    def separateSquares(self, squares):
        low = min(y for _, y, _ in squares)
        high = max(y + l for _, y, l in squares)

        def diff(h):
            above = 0.0
            below = 0.0
            for _, y, l in squares:
                top = y + l
                area = l * l

                if h <= y:
                    above += area
                elif h >= top:
                    below += area
                else:
                    b = (h - y) * l
                    below += b
                    above += area - b

            return above - below

        for _ in range(80): 
            mid = (low + high) / 2.0
            if diff(mid) > 0:
                low = mid
            else:
                high = mid

        return (low + high) / 2.0
