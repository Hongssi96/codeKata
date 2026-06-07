function solution(nums) {
  let answer = 0;
  const map = new Map();

  for (const num of nums) {
    if (!map.has(num)) {
      map.set(num, 1);
      answer++;
    }
  }

  const maxPick = nums.length / 2;

  return Math.min(answer, maxPick);
}
