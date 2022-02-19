package com.tictactoe.test;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;

@SpringBootApplication
public class TestApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
		
		Scanner in = new Scanner(System.in);
		
		
		System.out.print("Enter Player 1 name : ");
		String player1 = in.nextLine();
		System.out.print("Enter Player 2 name : ");
		String player2 = in.nextLine();
		
		System.out.print("Enter board size : ");
		int p = in.nextInt();
		
		char [] [] board = new char[p][p];
		
		for(int a=0;a<p;a++) {
			for (int b=0;b<p;b++) {
				board[a][b] = '-';
			}
		}
		
		boolean isP1 = true; 
		boolean gameover = false;
		
		while(!gameover) {
		showBoard(board,p);
		
		char symbol = ' ';
		if(isP1) {
			symbol='X';
		}else {
			symbol='O';
		}
		
		
		if(isP1) {
			System.out.println(player1 + "'s Turn :");
		}else {
			System.out.println(player2 + "'s Turn :");
		}
		
		int r,c;
		int q = p-1;
		while(true) {
			System.out.print("Enter row 0 - " + q + " :");
			r = in.nextInt();
			while (r < 0 || r > q) {
				System.out.println("Value not valid!");
				System.out.print("Enter row 0 - " + q + " :");
				r = in.nextInt();
			}
			System.out.print("Enter collumn 0 - " + q + " :");
			c = in.nextInt();
			while (c < 0 || c > q) {
				System.out.println("Value not valid!");
				System.out.print(" Enter collumn 0 - " + q + " :");
				c = in.nextInt();
			}
	
		
		if (r < 0 || c < 0 || r > p || c > p) {
			System.out.println("Row and collumns out of bounds");
		}else if(board[r][c] != '-') {
			System.out.println("Already selected");
		}else {
			break;
		}
	}
		board[r][c] = symbol;
		
		
		if(checkWon(board, p) == 'X') {
			System.out.println(player1 +" HAS WON!! CONGRATULATIONS!");
			gameover = true;
		}else if(checkWon(board, p) == 'O'){
			System.out.println(player2 +" HAS WON!! CONGRATULATIONS!");
			gameover = true;
		}else {
			if(Tied(board, p)) {
				System.out.println("game tied!");
			}else {
				isP1 = !isP1;
			}
		}
		}
	}
		
		public static void showBoard(char[] [] board, int p) {
			System.out.print("  ");
			for(int c=0;c<p;c++) {
				System.out.print(c+ " ");
			}
			System.out.println();
			for(int a=0;a<p;a++) {
				System.out.print(a + " ");
				for(int b=0;b<p;b++) {
					System.out.print(board[a][b] + " ");
				}
				System.out.println();
				System.out.println();
			}
		}
		
		public static char checkWon(char[][] board,int p) {
		
			//horizontal
			for(int a=0;a<p;a++) {
				int b=1;
				while (board[a][0] == board[a][b] && board[a][0] != '-') {
					if (b!=p-1) {
						b++;
					}else {
					return board[a][0];
					}	
				}
			}
			
			//vertical
			for(int c=0;c<p;c++) {
				int d=1;
				while(board[0][c] == board[d][c] && board[0][c] != '-' ) {
					if(d != p-1) {
						d++;
					}else {
						return board[0][c];
					}
				}
			}
			
			//diagonal down
				int e=0;
				int f=1;
				while(board[e][e] == board[f][f] && board[e][e] !='-') {
					if(f != p-1) {
						f++;
					}else {
						return board[e][e];
					}
				}
				//diagonal up
				int g=1;
				int h =p-1;
				while(board[h][0] == board[h-1][g] && board[h][0] != '-') {
						if(h != 0 && g!=h ) {
							h--;
							g++;
						}else {
							return board[p][0];
						}
				}
			
		return '-';
		}

		public static boolean Tied(char[][] board, int p) {
			for(int a=0;a<p;a++){
				for(int b=0;b<p;b++) {
					if (board[a][b] == '-') {
						return false;
					}	
				}
			}
			return  true;
		}
		
		
}

	
	
	
	

