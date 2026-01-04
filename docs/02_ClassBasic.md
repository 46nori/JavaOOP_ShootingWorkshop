# Step 2: Enemyクラスを作ってみよう

実際にJavaのファイルを作成してみましょう。
ここでは`src/step02_class_basic` パッケージの中に `Enemy.java` を作成します。

## 📦 パッケージ (package) について

ファイルの先頭に書く `package step02_class_basic;` は、このクラスがどのグループ（フォルダ）に属するかを示す **Java言語の仕組み** です。
これはオブジェクト指向の概念ではありませんが、たくさんのファイルを整理整頓し、名前の衝突（同じクラス名を使ってしまうこと）を防ぐために重要です。
この教材ではステップごとにフォルダを分けているため、以降のすべてのファイルでこのパッケージ宣言が登場します。

## ファイル: `Enemy.java`

```java
package step02_class_basic;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy {
    // フィールド (Field)
    double x;
    double y;
    double angle;
    double speed;
    int size = 40;

    // コンストラクタ (Constructor)
    public Enemy(double startX, double startY, double startAngle, double startSpeed) {
        x = startX;
        y = startY;
        angle = startAngle;
        speed = startSpeed;
    }

    // 表示メソッド
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval((int)x, (int)y, size, size);
    }

    // 消去メソッド
    public void erase(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval((int)x, (int)y, size, size);
    }

    // 移動メソッド
    public void move() {
        // Step 3, 4で実装します
    }
}
```

## 🔑 コンストラクタ (Constructor) とは

コードの中に `public Enemy(...)` という、クラス名と同じ名前のメソッドのようなものがあります。これが **コンストラクタ** です。

```java
public Enemy(double startX, double startY, double startAngle, double startSpeed) {
    x = startX;
    y = startY;
    angle = startAngle;
    speed = startSpeed;
}
```

### コンストラクタの3つの特徴

1. **メソッド名がクラス名と同じ**であること。
2. **戻り値の型（void や int など）を書かない**こと。
3. **`new` でインスタンスを作った瞬間に、自動的に1回だけ実行される**こと。

### なぜ必要なの？

生まれたばかりの敵キャラは、どこにいるのか（x, y）、どちらを向いているのか（angle）が決まっていません。
コンストラクタを使うことで、「生まれた瞬間に初期設定を完了させる」ことができます。これにより、「座標が設定されていない中途半端な敵」が作られるのを防げます。

## 📝 その他のコード解説

### フィールド (Field)

```java
double x;
double y;
...
```

クラスの「状態」を保存する変数です。メソッドの外側（クラスの直下）に書くことで、クラス内のどのメソッドからでも使えるようになります。

### メソッド (Method)

```java
public void draw(Graphics g) { ... }
```

クラスの「動作」を定義します。

- `draw`: 自分の姿を画面に描きます。
- `erase`: 自分の姿を背景色で塗りつぶして消します（アニメーションの準備）。
- `move`: 自分の座標を計算して移動します。

> **🛡️ 設計のコツ：責務（責任）を最小限にする**
> メソッドを作るときは、「1つのメソッドには1つの仕事だけをさせる」のが鉄則です。
>
> - `move` メソッドは「計算」だけを行い、画面への描画は行いません。
> - `draw` / `erase` メソッドは「描画」だけを行い、座標の計算は行いません。
>
> もし `move` の中で描画までしてしまうと、「計算だけしたい時」や「描画だけしたい時」に困ってしまいます。
> このように「誰が何をするか（責務）」を明確に分け、お互いの依存関係をなくすことで、後から変更しやすくバグの少ないプログラムになります。

### キャスト演算子 (int)

コードの中に `(int)x` という記述があります。
`x` や `y` は滑らかな動きを実現するために `double`（小数）で宣言しましたが、コンピュータの画面の座標（ピクセル）は整数で指定する必要があります。
そこで `(int)` をつけることで、「小数を整数に変換（小数点以下切り捨て）」しています。これを **キャスト (Cast)** と呼びます。

---

クラスができたら、次は [Step 3: Enemyクラスを動かしてみよう](03_Animation.md) です。
