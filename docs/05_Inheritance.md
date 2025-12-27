# Step 5: 継承 (Inheritance)

ゲームを作っていると、「直進する敵」の他に「波打って動く敵」や「追いかけてくる敵」など、色々な種類の敵を作りたくなります。
このとき、`Enemy` クラスをコピーして `WavyEnemy` クラスを作るとどうなるでしょうか？
もし「描画処理を修正したい」と思ったとき、すべてのファイルを修正しなければならず、大変です。

そこで登場するのが **継承 (Inheritance)** です。
継承を使うと、**「共通部分は親クラスに任せて、違う部分だけを自分で書く」** ことができます。

## 🔑 継承の仕組み

### 親クラスと子クラス
- **親クラス (Super Class)**: ベースとなるクラス。ここでは `Enemy` クラスです。共通のフィールド（x, yなど）やメソッド（drawなど）を持ちます。
- **子クラス (Sub Class)**: 親クラスを拡張したクラス。ここでは `StraightEnemy` や `WavyEnemy` です。

### 重要なキーワード

#### 1. extends（拡張する）
クラス名の後ろに `extends 親クラス名` をつけると、その親クラスの機能（フィールドやメソッド）をすべて引き継ぐことができます。
```java
public class StraightEnemy extends Enemy { ... }
```
これで `StraightEnemy` は、自分で書かなくても `x` や `y` を持ち、`draw()` できるようになります。

#### 2. super（親クラスの参照）
子クラスのコンストラクタでは、まず最初に **「親クラスのコンストラクタ」** を呼んで、親としての初期化（座標のセットなど）を完了させる必要があります。
```java
public StraightEnemy(double startX, ...) {
    super(startX, ...); // 親(Enemy)のコンストラクタを呼び出す
}
```

#### 3. @Override（上書き）
親クラスにあるメソッドと同じ名前のメソッドを子クラスで作ることで、動作を上書き変更できます。これを **オーバーライド** と呼びます。
```java
@Override
public void move() {
    // 独自の動きを書く
}
```

---

## 実装例 (`src/step05_inheritance`)

### 直進する敵 (`StraightEnemy.java`)
`Enemy` クラスの機能をそのまま使います。特別なことは何もしなくて良いため、コードはとても短くなります。

```java
public class StraightEnemy extends Enemy {
    public StraightEnemy(double startX, double startY, double startAngle, double startSpeed) {
        super(startX, startY, startAngle, startSpeed);
    }
    // move() は書いていないので、親クラス(Enemy)のmove()がそのまま使われます
}
```

### 波打つ敵 (`WavyEnemy.java`)
`move` メソッドをオーバーライドして、動きを変更します。

```java
public class WavyEnemy extends Enemy {
    public WavyEnemy(double startX, double startY, double startAngle, double startSpeed) {
        super(startX, startY, startAngle, startSpeed);
    }

    // 親クラスのメソッドを上書きする (Override)
    @Override
    public void move() {
        super.move(); // 親のmove（直進計算）を再利用！
        
        // さらに独自の動きを追加
        y += Math.sin(x * 0.05) * 5; // 波打つ動き
    }
    
    // 色を変えるためにdrawもオーバーライド
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval((int)x, (int)y, 40, 40);
    }
}
```

## 実行方法
Eclipse上で `src/step05_inheritance/GameMain.java` を右クリックし、**[Run As]** > **[Java Application]** を選択します。
青い敵（直進）と緑の敵（波打ち）が表示されれば成功です！

次は [Step 6: ポリモーフィズム (Polymorphism)](06_Polymorphism.md) です。
