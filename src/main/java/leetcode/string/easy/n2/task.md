## 290. Word Pattern

Given a `pattern` and a string `s`, find if `s` follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in `pattern` and a __non-empty__ word in `s`.
Specifically:

- Each letter in `pattern` maps to __exactly__ one unique word in `s`.
- Each unique word in `s` maps to __exactly__ one letter in `pattern`.
- No two letters map to the same word, and no two words map to the same letter.

#### Example 1:

>__Input:__ pattern = "abba", s = "dog cat cat dog"

>__Output:__ true

>__Explanation:__
>
>The bijection can be established as:
>
>`a` maps to `dog`.
>`b` maps to `cat`.
#### Example 2:

>__Input:__ pattern = "abba", s = "dog cat cat fish"

>__Output:__ false

#### Example 3:

>__Input:__ pattern = "aaaa", s = "dog cat cat dog"

>__Output:__ false

#### Constraints:

- `1 <= pattern.length <= 300`
- `pattern` contains only lower-case English letters.
- `1 <= s.length <= 3000`
- `s` contains only lowercase English letters and spaces `' '`.
- `s` __does not contain__ any leading or trailing spaces.
- All the words in `s` are separated by a __single space__.

#### https://leetcode.com/problems/word-pattern/

Closed Solution: https://leetcode.com/problems/word-pattern/editorial/