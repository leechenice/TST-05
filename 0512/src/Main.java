import java.util.*;

public class Main {
    public static int myCompareTo(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int lim = Math.min(len1,len2);
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        for (int i = 0; i < lim; i++) {
            if(chars1[i] != chars2[i])
                return chars1[i] - chars2[i];
        }
        return len1 - len2;

    }
    private static void testMethod(){

        System.out.println("testMethod");

    }
    static class UserException extends Exception {
        public UserException() {
            super();
        }

        public UserException(String message) {
            super(message);
        }
    }
    public static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String str1 = scanner.next();
        System.out.println("请输入密码：");
        String str2 = scanner.next();
        if (!str1.equals("admin") || !str2.equals("123456")) {
            try {
                throw new UserException("用户名或密码不正确");
            } catch (UserException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("登陆成功");
        }
    }
    public static class A<T> {
        T value;

        A(T value) {
            this.value = value;
        }

        T get() {
            return value;
        }
    }
    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
//    public int getImportance(List<Employee> employees, int id) {
//        for (Employee e:employees) {
//            if (e.id == id) {
//                if (e.subordinates.size() == 0)
//                    return e.importance;
//                for (int subId:e.subordinates) {
//                    e.importance += getImportance(employees,subId);
//                }
//                return e.importance;
//            }
//        }
//        return 0;
//    }
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> map = new HashMap<>();
        for (Employee e:employees) {
            map.put(e.id,e);
        }
        return getImportanceHelper(map,id);
    }
    public int getImportanceHelper(Map<Integer,Employee> map,int id) {
        Employee employee = map.get(id);
        for (int subId:employee.subordinates) {
            employee.importance += getImportanceHelper(map,subId);
        }
        return employee.importance;
    }
    public int findJudge(int N, int[][] trust) {
        int[] outDegree = new int[N + 1];
        int[] inDegree = new int[N + 1];
        for (int[] ints : trust) {
            int from = ints[0];
            int to = ints[1];
            outDegree[from]++;
            inDegree[to]++;
        }
        for (int i = 0; i <= N; i++) {
            if (outDegree[i] == 0 && inDegree[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i:A) {
            sum += i;
        }

        int oneThirdSum = 0;
        int flag = 0;
        for (int i:A) {
            oneThirdSum += i;
            if (oneThirdSum == sum / 3) {
                flag++;
                oneThirdSum = 0;
            }
        }
        return flag >= 3;
    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        for(; k > 0; k--) {
            int previous = grid[grid.length - 1][grid[0].length - 1];
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    int tmp = grid[row][col];
                    grid[row][col] = previous;
                    previous = tmp;
                }
            }
        }
        List<List<Integer>> lists = new ArrayList<>();
        for (int[] ints:grid) {
            List<Integer> list = new ArrayList<>();
            lists.add(list);
            for (int i:ints) {
                list.add(i);
            }
        }
        return lists;
    }

    public static void main(String[] args) {
    }
}
