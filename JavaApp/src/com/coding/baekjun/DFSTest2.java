package com.coding.baekjun;

import java.util.Scanner;

public class DFSTest2 {
	
	static int vertex; //������ ����
    static int startVertex; //���� ����
    static int[][] vertexMap; //���� ��� ��
    static int[] vertexVisit; //������ �湮 ���θ� ����Ű�� �迭
    static int vt1, vt2;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        vertex = scan.nextInt(); //������ ���� �Է�
        startVertex = Integer.parseInt(scan.nextLine().trim()); //������ ���� �Է�
        vertexMap = new int[vertex+1][vertex+1]; //+1�� ��Ų ���Ĵ� ������ ������ 0�̾ƴ� 1�ν����ϱ� ���ؼ��̴�.!
        vertexVisit = new int[vertex+1]; //+1�� ��Ų ���Ĵ� ������ ������ 0�̾ƴ� 1�ν����ϱ� ���ؼ��̴�.!
        
        while(true) { 
            vt1 = scan.nextInt();
            vt2 = scan.nextInt();
        
            if(vt1 < 0 && vt2 < 0) //�� ���� ���� 0���� ���� ��� break;
                break;
            
            vertexMap[vt1][vt2] = vertexMap[vt2][vt1] = 1; //���� vt1�� vt2�� ����Ǿ����� ǥ��
            //��������� ������ �����ϸ� ���� �ڵ带 ������ �� �ֽ��ϴ�. ���� ��� 1���� 2������ ����Ǿ����� [1][2] �� [2][1] �迭�� �ڸ��� 1�̵ȴ�.

        }
        
        dfs(startVertex); //dfs�� �����մϴ�.
        
    }
    
    public static void dfs(int start) {
        vertexVisit[start] = 1;
        
        for(int i = 1; i <=vertex; i++) {
            if(vertexMap[start][i] == 1 && vertexVisit[i] == 0) {
                System.out.println(start + "->" + i + "�� �̵��մϴ�");
                dfs(i); 
            }
        }
    } 

}
