package org.example.test;

import sun.misc.BASE64Decoder;

import java.io.IOException;

public class Decode {
    public static void main(String[] args) throws IOException {
        String s = "PHBsaXN0IHZlcnNpb249IjEuMCI+CjxkaWN0PgoJPGtleT5QYXlsb2FkQ29udGVudDwva2V5PgoJ\n" +
                "PGFycmF5PgoJCTxkaWN0PgoJCQk8a2V5PlBheWxvYWREZXNjcmlwdGlvbjwva2V5PgoJCQk8c3Ry\n" +
                "aW5nPjwvc3RyaW5nPgoJCQk8a2V5PlBheWxvYWREaXNwbGF5TmFtZTwva2V5PgoJCQk8c3RyaW5n\n" +
                "PlJlc3RyaWN0aW9uczwvc3RyaW5nPgoJCQk8a2V5PlBheWxvYWRJZGVudGlmaWVyPC9rZXk+CgkJ\n" +
                "CTxzdHJpbmc+Y28ubXltZG0ucmVzdHJpY3Rpb25zLnJlc3RyaWN0aW9uczE8L3N0cmluZz4KCQkJ\n" +
                "PGtleT5QYXlsb2FkT3JnYW5pemF0aW9uPC9rZXk+CgkJCTxzdHJpbmc+PC9zdHJpbmc+CgkJCTxr\n" +
                "ZXk+UGF5bG9hZFR5cGU8L2tleT4KCQkJPHN0cmluZz5jb20uYXBwbGUuYXBwbGljYXRpb25hY2Nl\n" +
                "c3M8L3N0cmluZz4KCQkJPGtleT5QYXlsb2FkVVVJRDwva2V5PgoJCQk8c3RyaW5nPjg0MzA2NThB\n" +
                "LUY1MDQtNDA2MC1BOTUyLTc2MkUwMzg3NjY5Nzwvc3RyaW5nPgoJCQk8a2V5PlBheWxvYWRWZXJz\n" +
                "aW9uPC9rZXk+CgkJCTxpbnRlZ2VyPjE8L2ludGVnZXI+CgkJCTxrZXk+YWxsb3dBZGRpbmdHYW1l\n" +
                "Q2VudGVyRnJpZW5kczwva2V5PgoJCQk8dHJ1ZS8+CgkJCTxrZXk+YWxsb3dBcHBJbnN0YWxsYXRp\n" +
                "b248L2tleT4KCQkJPGZhbHNlLz4KCQkJPGtleT5hbGxvd0Fzc2lzdGFudDwva2V5PgoJCQk8dHJ1\n" +
                "ZS8+CgkJCTxrZXk+YWxsb3dBc3Npc3RhbnRXaGlsZUxvY2tlZDwva2V5PgoJCQk8dHJ1ZS8+CgkJ\n" +
                "CTxrZXk+YWxsb3dDYW1lcmE8L2tleT4KCQkJPHRydWUvPgoJCQk8a2V5PmFsbG93Q2xvdWRCYWNr\n" +
                "dXA8L2tleT4KCQkJPHRydWUvPgoJCQk8a2V5PmFsbG93Q2xvdWREb2N1bWVudFN5bmM8L2tleT4K\n" +
                "CQkJPHRydWUvPgoJCQk8a2V5PmFsbG93RGlhZ25vc3RpY1N1Ym1pc3Npb248L2tleT4KCQkJPHRy\n" +
                "dWUvPgoJCQk8a2V5PmFsbG93RXhwbGljaXRDb250ZW50PC9rZXk+CgkJCTx0cnVlLz4KCQkJPGtl\n" +
                "eT5hbGxvd0dsb2JhbEJhY2tncm91bmRGZXRjaFdoZW5Sb2FtaW5nPC9rZXk+CgkJCTx0cnVlLz4K\n" +
                "CQkJPGtleT5hbGxvd0luQXBwUHVyY2hhc2VzPC9rZXk+CgkJCTx0cnVlLz4KCQkJPGtleT5hbGxv\n" +
                "d011bHRpcGxheWVyR2FtaW5nPC9rZXk+CgkJCTx0cnVlLz4KCQkJPGtleT5hbGxvd1Bob3RvU3Ry\n" +
                "ZWFtPC9rZXk+CgkJCTx0cnVlLz4KCQkJPGtleT5hbGxvd1NhZmFyaTwva2V5PgoJCQk8dHJ1ZS8+\n" +
                "CgkJCTxrZXk+YWxsb3dTY3JlZW5TaG90PC9rZXk+CgkJCTx0cnVlLz4KCQkJPGtleT5hbGxvd1Vu\n" +
                "dHJ1c3RlZFRMU1Byb21wdDwva2V5PgoJCQk8dHJ1ZS8+CgkJCTxrZXk+YWxsb3dWaWRlb0NvbmZl\n" +
                "cmVuY2luZzwva2V5PgoJCQk8dHJ1ZS8+CgkJCTxrZXk+YWxsb3dWb2ljZURpYWxpbmc8L2tleT4K\n" +
                "CQkJPHRydWUvPgoJCQk8a2V5PmFsbG93WW91VHViZTwva2V5PgoJCQk8dHJ1ZS8+CgkJCTxrZXk+\n" +
                "YWxsb3dpVHVuZXM8L2tleT4KCQkJPHRydWUvPgoJCQk8a2V5PmZvcmNlRW5jcnlwdGVkQmFja3Vw\n" +
                "PC9rZXk+CgkJCTxmYWxzZS8+CgkJCTxrZXk+Zm9yY2VJVHVuZXNTdG9yZVBhc3N3b3JkRW50cnk8\n" +
                "L2tleT4KCQkJPGZhbHNlLz4KCQkJPGtleT5yYXRpbmdBcHBzPC9rZXk+CgkJCTxpbnRlZ2VyPjEw\n" +
                "MDA8L2ludGVnZXI+CgkJCTxrZXk+cmF0aW5nTW92aWVzPC9rZXk+CgkJCTxpbnRlZ2VyPjEwMDA8\n" +
                "L2ludGVnZXI+CgkJCTxrZXk+cmF0aW5nUmVnaW9uPC9rZXk+CgkJCTxzdHJpbmc+dXM8L3N0cmlu\n" +
                "Zz4KCQkJPGtleT5yYXRpbmdUVlNob3dzPC9rZXk+CgkJCTxpbnRlZ2VyPjEwMDA8L2ludGVnZXI+\n" +
                "CgkJCTxrZXk+c2FmYXJpQWNjZXB0Q29va2llczwva2V5PgoJCQk8aW50ZWdlcj4yPC9pbnRlZ2Vy\n" +
                "PgoJCQk8a2V5PnNhZmFyaUFsbG93QXV0b0ZpbGw8L2tleT4KCQkJPHRydWUvPgoJCQk8a2V5PnNh\n" +
                "ZmFyaUFsbG93SmF2YVNjcmlwdDwva2V5PgoJCQk8dHJ1ZS8+CgkJCTxrZXk+c2FmYXJpQWxsb3dQ\n" +
                "b3B1cHM8L2tleT4KCQkJPHRydWUvPgoJCQk8a2V5PnNhZmFyaUZvcmNlRnJhdWRXYXJuaW5nPC9r\n" +
                "ZXk+CgkJCTxmYWxzZS8+CgkJPC9kaWN0PgoJPC9hcnJheT4KCTxrZXk+UGF5bG9hZERlc2NyaXB0\n" +
                "aW9uPC9rZXk+Cgk8c3RyaW5nPlByb2ZpbGUgZGVzY3JpcHRpb24uPC9zdHJpbmc+Cgk8a2V5PlBh\n" +
                "eWxvYWREaXNwbGF5TmFtZTwva2V5PgoJPHN0cmluZz5HZW5lcmFsPC9zdHJpbmc+Cgk8a2V5PlBh\n" +
                "eWxvYWRJZGVudGlmaWVyPC9rZXk+Cgk8c3RyaW5nPmNvLm15bWRtLnJlc3RyaWN0aW9uczwvc3Ry\n" +
                "aW5nPgoJPGtleT5QYXlsb2FkT3JnYW5pemF0aW9uPC9rZXk+Cgk8c3RyaW5nPjwvc3RyaW5nPgoJ\n" +
                "PGtleT5QYXlsb2FkUmVtb3ZhbERpc2FsbG93ZWQ8L2tleT4KCTxmYWxzZS8+Cgk8a2V5PlBheWxv\n" +
                "YWRUeXBlPC9rZXk+Cgk8c3RyaW5nPkNvbmZpZ3VyYXRpb248L3N0cmluZz4KCTxrZXk+UGF5bG9h\n" +
                "ZFVVSUQ8L2tleT4KCTxzdHJpbmc+MUU4MjY0NEEtQjRCRi00RkM0LTgxQTgtNTdCRTFDOTg4MTg1\n" +
                "PC9zdHJpbmc+Cgk8a2V5PlBheWxvYWRWZXJzaW9uPC9rZXk+Cgk8aW50ZWdlcj4xPC9pbnRlZ2Vy\n" +
                "Pgo8L2RpY3Q+CjwvcGxpc3Q+Cg==";
        byte[] bytes = new BASE64Decoder().decodeBuffer(s);
        System.out.println(new String(bytes));
    }
}
