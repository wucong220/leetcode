package contest;

public class P877StoneGame {
	public boolean stoneGame(int[] piles) {

		int dg[][] = new int[piles.length][piles.length];

		for (int i = 0; i < piles.length; i++) {
			for (int j = i; j < piles.length; j++) {
				if (i + 1 == j)
					dg[i][i + 1] = Math.abs(piles[i] - piles[i + 1]);
				else if (i == j)
					dg[i][i] = piles[i];
				else {
					dg[i][j] = Math.max(
							Math.min(dg[i + 1][j - 1] + piles[i] - piles[j], dg[i + 2][j] + piles[i] - piles[i + 1]),
							Math.min(dg[i + 1][j - 1] + piles[j] - piles[i], dg[i][j - 2] + piles[j] - piles[j - 1]));
				}
			}
		}
		return dg[piles.length - 1][piles.length - 1] > 0;
	}

	public static void main(String[] args) {
		System.out.println(new P877StoneGame().stoneGame(new int[] { 5, 3, 4, 5 }));
	}
}
