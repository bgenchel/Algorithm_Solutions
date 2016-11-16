# Given a roman numeral, convert it to an integer.
# Input is guaranteed to be within the range from 1 to 3999.

class Solution(object): 
    def romanToInt(self, s):
        print "\n converting string " + s
        """
        :type s: str
        :rtype: int
        """
        map = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
        integer = 0
        greatest = map[s[-1]]
        index = len(s) - 1
        while index >= 0:
            print "head of while loop, on char" + s[index]
            print "current greatest = " + greatest
            cval = map[s[index]]
            if cval < greatest:
                print "current value less than greatest"
                substr = ""
                while cval < greatest:
                    substr = substr + s[index]
                    index = index - 1
                    cval = map[s[index]]
                integer = integer - self.romanToInt(substr)
            else:
                "current value greater than greatest"
                integer = integer + cval
                index = index - 1
                greatest = cval
                
        return integer
           
if __name__ == '__main__':
    s = raw_input("Enger Roman Numeral String:  ")
    sol = Solution()
    i = sol.romanToInt(s)
    print "as integer: " + str(i)