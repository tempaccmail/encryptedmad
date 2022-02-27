import 'package:flutter/material.dart';

class Home extends StatelessWidget {
  const Home({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Center(child: Text("Exercise 2")),
      ),
      body: Center(
        child: Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ClipRRect(
              child: Image.asset('assets/images/pic1.png',width: 150,height: 150),
            ),
            SizedBox(width: 20),
            ClipRRect(
              child: Image.asset('assets/images/pic2.png',width: 150,height: 150),
            ),
          ],

        ),
      ),
    );
  }
}
