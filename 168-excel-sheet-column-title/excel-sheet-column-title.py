class Solution:
    def convertToTitle(self, columnNumber):
        result = []

        while columnNumber > 0:
            columnNumber -= 1  
            char = chr(columnNumber % 26 + ord('A'))
            result.append(char)
            columnNumber //= 26

        return "".join(reversed(result))

        