package coding.dp;

public class ProbOfKnight {

	public static double probOfKnightInBoard(int x, int y, int steps) {
		double probdp[][][] = new double[8][8][steps + 1];
		int dx[] = { 1, 1, -1, -1, 2, 2, -2, -2 };
		int dy[] = { 2, -2, -2, 2, 1, -1, 1, -1 };
		for (int j = 0; j < dx.length; j++) {
			for (int k = 0; k < dy.length; k++) {
				probdp[j][k][0] = 1;
			}
		}
		for (int i = 1; i <= steps; i++) {
			for (int j = 0; j < dx.length; j++) {
				for (int k = 0; k < dy.length; k++) {
					double prob = 0.0;
					for (int l = 0; l < 8; l++) {
						int nx = j + dx[l];
						int ny = k + dy[l];
						if (inside(nx, ny)) {
							prob += probdp[nx][ny][i - 1] / 8;
						}
					}
					probdp[j][k][i] = prob;
				}
			}
		}

		return probdp[x][y][steps];
	}

	private static boolean inside(int nx, int ny) {
		if (nx < 0 || ny < 0 || nx >= 8 || ny >= 8)
			return false;
		return true;
	}

	public static void main(String[] args) {
		System.out.println(probOfKnightInBoard(0, 0, 3));
	}
}
