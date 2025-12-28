# JavaOOP_ShootingWorkshop

Javaのオブジェクト指向（クラス、継承、ポリモーフィズム、カプセル化）を、シューティングゲームの敵キャラクターを作りながら学ぶためのワークショップ教材です。

## 🚀 はじめ方

このプロジェクトはEclipseで学習することを想定して作られています。
はじめに[Eclipseをインストール](https://www.eclipse.org/downloads/)してください。
次に、状況に合わせて以下のいずれかの方法でインポートしてください。

### 方法A: すでにフォルダが手元にある場合
1.  **Eclipseを起動**します。
2.  メニューバーから **[File]** > **[Open Projects from File System...]** を選択します。
3.  **[Directory]** ボタンをクリックし、このフォルダ `JavaOOP_ShootingWorkshop` を選択します。
4.  **[Finish]** をクリックします。

### 方法B: GitHubから直接インポートする場合
1.  **Eclipseを起動**します。
2.  メニューバーから **[File]** > **[Import...]** を選択します。
3.  **[Git]** > **[Projects from Git (with smart import)]** を選び、**[Next]** を押します。
4.  **[GitHub]** を選択し、**[Next]** を押します。
5.  検索欄に `JavaOOP_ShootingWorkshop` と入力して **Search**ボタンを押します。
7.  検索結果に **46nori/JavaOOP_ShootingWorkshop (Java)(...** が表示されるので選択し、**[Next]** を押します。
8.  ブランチを選択します。(通常はmainにチェックが入っていればOK) **[Next]** を押します。
9.  Directoryを自分の好きな作業フォルダに設定し、**[Next]** を押します。
10.  **[Finish]** をクリックします。

これで、`src` フォルダ内の各ステップ（`step01`〜`step07`）がパッケージとして認識されます。

## 📚 学習カリキュラム

インポートが完了したら、`docs` フォルダ内のドキュメントを順番に読み進めてください。

- [00_Index.md](docs/00_Index.md) - 目次と概要
- [01_Concept.md](docs/01_Concept.md) - クラスの概念
- [02_ClassBasic.md](docs/02_ClassBasic.md) - クラスの基本実装
- [03_Animation.md](docs/03_Animation.md) - アニメーション
- [04_Array.md](docs/04_Array.md) - 配列とループ
- [05_Inheritance.md](docs/05_Inheritance.md) - 継承 (Inheritance)
- [06_Polymorphism.md](docs/06_Polymorphism.md) - ポリモーフィズム (Polymorphism)
- [07_Encapsulation.md](docs/07_Encapsulation.md) - カプセル化 (Encapsulation)

## 🛠 動作環境
- Java Development Kit (JDK) 8以上
- Eclipse IDE for Java Developers

---

<details>
<summary>参考：コマンドラインで実行する場合</summary>

Eclipseを使わず、ターミナルから直接実行することも可能です。

1. `src` ディレクトリに移動します。
   ```bash
   cd src
   ```
2. コンパイルします（例：Step 4の場合）。
   ```bash
   javac step04_array/*.java
   ```
3. パッケージ名を指定して実行します。
   ```bash
   java step04_array.GameMain
   ```
</details>
